package hashFile;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class hashfile {
    public static byte[] SHA1Checksum(InputStream is) throws Exception {
        // 用于计算hash值的文件缓冲区
        byte[] buffer = new byte[1024];
        // 使用SHA1哈希/摘要算法
        MessageDigest complete = MessageDigest.getInstance("SHA-1");
        int numRead = 0;
        do {
            // 读出numRead字节到buffer中
            numRead = is.read(buffer); //如果 b（这里是buffer） 的长度为 0，则不读取任何字节并返回 0；
            // 否则，尝试读取至少一个字节。如果因为流位于文件末尾而没有可用的字节，则返回值 -1；
            // 否则，至少读取一个字节并将其存储在 b 中。
            if (numRead > 0) {
                // 根据buffer[0:numRead]的内容更新hash值
                complete.update(buffer, 0, numRead);
            }
            // 文件已读完，退出循环
        } while (numRead != -1);
        // 关闭输入流
        is.close();
        // 返回SHA1哈希值
        return complete.digest();
    }


    public static byte[] dfs(String path, int layer) throws Exception {
        // 使用SHA1哈希/摘要算法，用于更新当前目录的hash值, 读入是字节数组，输出也是字节数组
        MessageDigest complete = MessageDigest.getInstance("SHA-1");

        File dir = new File(path);
        File[] fs = dir.listFiles();
        //接下来对文件和文件夹按照名称进行排序
        List fileList = Arrays.asList(fs);
        Collections.sort(fileList, new Comparator<File>() {
            @Override //表示重写方法
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1; //文件夹优先，-1表示前者小，1表示前者大
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(int i = 0; i < fs.length; i++) {
            if(fs[i].isFile()) {
                //System.out.println("file " + fs[i].getName()); //这句话改成对子文件调用SHA1函数
                InputStream s = new FileInputStream(fs[i]); //将file类型对象转换为InputStream类型
                complete.update(fs[i].getName().getBytes()); //将文件名称也加入hash值中
                complete.update(SHA1Checksum(s));
            }
            if(fs[i].isDirectory()) {
                //System.out.println("directory " + fs[i].getName()); //这句话改成对子文件夹调用dfs函数，已经有了
                complete.update(fs[i].getName().getBytes()); //将文件夹名称也加入hash值中
                complete.update(dfs(path + File.separator + fs[i].getName(),layer + 1));
            }
        }

        //System.out.println(Arrays.toString(complete.digest()));
        if (layer == 1) System.out.println(byteArrayToHex(complete.digest())); //只输出根目录的hash值
        return complete.digest();
    }

    //下面这个函数用于将字节数组换成成16进制的字符串
    public static String byteArrayToHex(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray =new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf]; //0xf表示16进制的15
            resultCharArray[index++] = hexDigits[b& 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a route:");
        String path = input.nextLine();
        input.close();
        try {
            byte[] res = new byte[1024];
            res = dfs(path, 1);
            //System.out.println(byteArrayToHex(res)); //res对象属于冗余功能，和dfs内部的打印功能选择一个就可以
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(new String(res));
    }
}
