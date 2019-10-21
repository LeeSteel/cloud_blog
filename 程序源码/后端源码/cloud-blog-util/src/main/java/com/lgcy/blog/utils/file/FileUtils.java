package com.lgcy.blog.utils.file;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @ClassName: FileUtils
 * @Description:文件工具类
 * @author chenye
 * @date 2019年9月8日
 *
 */
public class FileUtils {
	
    /**
     * @Title: readFile 
     * @Description: 读取文件内容(字符流)
     * @param @param is				
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String readFile(InputStream is) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                sb.append(readLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 
     * @Title: isFileExist
     * @Description: 验证是否是一个文件
     * @param @param fileName	文件地址+文件名
     * @param @return    参数
     * @return boolean    返回类型
     * @author chenye
     */
    public static boolean isFileExist(String fileName) {
        return new File(fileName).isFile();
    }

    /**
     * 
     * @Title: makeDirectory 
     * @Description: 创建指定的目录。 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。(注意：可能会在返回false的时候创建部分父目录。)
     * @param @param file
     * @param @return    设定文件 
     * @return boolean    返回类型 
     * @author chenye
     */
    public static boolean makeDirectory(File file) {
        File parent = file.getParentFile();
        if (parent != null) {
            return parent.mkdirs();
        }
        return false;
    }

    /**
     * @Title: getFilePath 
     * @Description: TODO 从文件名得到文件绝对路径
     * @param @param fileName
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String getFilePath(String fileName) {
        File file = new File(fileName);
        return file.getAbsolutePath();
    }

    /**
     * 
     * @Title: toUNIXpath 
     * @Description: 将DOS/Windows格式的路径转换为UNIX/Linux格式的路径。(双反斜杠转但斜杠)
     * @param @param filePath
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String toUNIXpath(String filePath) {
        return filePath.replace("\\", "/");
    }

    /**
     * 
     * @Title: getUNIXfilePath 
     * @Description: 从文件名得到UNIX风格的文件绝对路径。
     * @param @param fileName
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String getUNIXfilePath(String fileName) {
        File file = new File(fileName);
        return toUNIXpath(file.getAbsolutePath());
    }

    /**
     * @Title: getFileExt 
     * @Description: TODO(得到文件后缀名) 
     * @param @param fileName
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String getFileExt(String fileName) {
        int point = fileName.lastIndexOf('.');
        int length = fileName.length();
        if (point == -1 || point == length - 1) {
            return "";
        } else {
            return fileName.substring(point + 1, length);
        }
    }

    /**
     * @Title: getNamePart 
     * @Description: 得到文件的名字部分。 实际上就是路径中的最后一个路径分隔符后的部分。
     * @param @param fileName
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String getNamePart(String fileName) {
        int point = getPathLastIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return fileName;
        } else if (point == length - 1) {
            int secondPoint = getPathLastIndex(fileName, point - 1);
            if (secondPoint == -1) {
                if (length == 1) {
                    return fileName;
                } else {
                    return fileName.substring(0, point);
                }
            } else {
                return fileName.substring(secondPoint + 1, point);
            }
        } else {
            return fileName.substring(point + 1);
        }
    }

    /**
     * 
     * @Title: getPathPart 
     * @Description: 得到文件名中的父路径部分。 对两种路径分隔符都有效。 不存在时返回""。
     * 				   如果文件名是以路径分隔符结尾的则不考虑该分隔符，例如"/path/"返回""。
     * @param @param fileName
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String getPathPart(String fileName) {
        int point = getPathLastIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return "";
        } else if (point == length - 1) {
            int secondPoint = getPathLastIndex(fileName, point - 1);
            if (secondPoint == -1) {
                return "";
            } else {
                return fileName.substring(0, secondPoint);
            }
        } else {
            return fileName.substring(0, point);
        }
    }

    /**
     * @Title: getPathLastIndex 
     * @Description: 得到路径分隔符在文件路径中最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     * @param @param fileName
     * @param @return    设定文件 
     * @return int    返回类型 
     * @author chenye
     */
    public static int getPathLastIndex(String fileName) {
        int point1 = fileName.lastIndexOf("/");
        int point2 = fileName.lastIndexOf("\\");
        
        return point1 > point2 ? point1 : point2;
    }

    /**
     * @Title: getPathLastIndex 
     * @Description: 得到路径分隔符在文件路径中指定位置前最后出现的位置。
     * @param @param fileName
     * @param @param fromIndex		指定下标
     * @param @return    设定文件 
     * @return int    返回类型 
     * @author chenye
     */
    public static int getPathLastIndex(String fileName, int fromIndex) {
    	int point1 = fileName.lastIndexOf("/", fromIndex);
        int point2 = fileName.lastIndexOf("\\", fromIndex);
        
        return point1 > point2 ? point1 : point2;
    }

    /**
     * @Title: getPathIndex 
     * @Description: 得到路径分隔符在文件路径中首次出现的位置。
     * @param @param fileName
     * @param @return    设定文件 
     * @return int    返回类型 
     * @author chenye
     */
    public static int getPathIndex(String fileName) {
        int point1 = fileName.indexOf("/");
        int point2 = fileName.indexOf("\\");
        
        if (point1 == -1)
        	return point2;
        	
        return point1 < point2 ? point1 : point2;
    }

    /**
     * @Title: getPathIndex 
     * @Description: 得到路径分隔符在文件路径中指定位置后首次出现的位置。
     * @param @param fileName
     * @param @param fromIndex
     * @param @return    设定文件 
     * @return int    返回类型 
     * @author chenye
     */
    public static int getPathIndex(String fileName, int fromIndex) {
        int point1 = fileName.indexOf("/", fromIndex);
        int point2 = fileName.indexOf("\\", fromIndex);
        
        if (point1 == -1)
        	return point2;
        	
        return point1 < point2 ? point1 : point2;
    }

    /**
     * @Title: removeFileExt 
     * @Description:  去掉后缀名
     * @param @param filename
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String removeFileExt(String filename) {
        int index = filename.lastIndexOf(".");
        if (index != -1) {
            return filename.substring(0, index);
        } else {
            return filename;
        }
    }

    /**
     * @Title: getSubpath 
     * @Description: TODO(得到相对路径。 文件名不是目录名的子节点时返回文件名。) 
     * @param @param pathName
     * @param @param fileName
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author chenye
     */
    public static String getSubpath(String pathName, String fileName) {
        int index = fileName.indexOf(pathName);
        if (index != -1) {
            return fileName.substring(index + pathName.length() + 1);
        } else {
            return fileName;
        }
    }

    /**
     * @Title: copy 
     * @Description: TODO(复制文件) 
     * @param @param src
     * @param @param dst
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @author chenye
     */
    public static void copy(File src, File dst) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }

    /**
     * 
     * @Title: copy 
     * @Description: 把源文件内容追加到目标文件末尾(若数据文件不存在会自动创建)
     * @param @param src		源文件(数据来源)
     * @param @param dst		数据文件(存储数据的文件)
     * @param @param append		true：追加，false：覆盖
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @author chenye
     */
    public static void copy(File src, File dst, boolean append) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst, append), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }
    
    /** 
     * 
     * @Title: deleteDirectory 
     * @Description: 删除目录以及目录下的文件 
     * @param @param sPath		被删除目录的路径 
     * @return boolean    目录删除成功返回true，否则返回false 
     * @author chenye
     */
	public static boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	} 

	/** 
	 * 
	 * @Title: deleteFile 
	 * @Description: 删除单个文件 
	 * @param @param sPath		被删除文件path 
	 * @param @return    设定文件 
	 * @return boolean    删除成功返回true，否则返回false 
	 * @author chenye
	 */
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}
}
