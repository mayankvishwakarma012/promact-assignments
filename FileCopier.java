import java.io.*;

public class FileCopier {
    public static void main(String[] args) {
        String fileFullName = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("Enter the file name to be copied: ");
            fileFullName = br.readLine(); // reading the filename with extention.


            int size = fileFullName.length();
            int pos = fileFullName.lastIndexOf('.');

            // dividing it into file name and file extention.
            String fileName = fileFullName.substring(0 , pos);
            String fileExtention = fileFullName.substring(pos, size);
            
            File file = new File(fileFullName);

            if(file.exists() && !file.isDirectory()) //checking the file exist or not 
                {
                    int i = 1;
                    
                    String newFileName = fileName + " - Copy" + fileExtention;
                    File newFile = new File(newFileName);
                    while(newFile.exists()) 
                        {
                            newFileName = fileName + " - Copy (" + i + ")" + fileExtention;
                            newFile = new File(newFileName);
                            i++;
                        }
                    //creating a copy
                    InputStream in = new FileInputStream(file);
                    OutputStream out = new FileOutputStream(newFile);
                    byte[] buffer = new byte[1024];
                    int length;
                    while((length = in.read(buffer)) > 0) {
                        out.write(buffer, 0, length);
                    }
                    in.close();
                    out.close();
                    
                    System.out.println("Success : File copied to " + newFileName);
                } 
            else 
                {
                    System.out.println("Arert : File not found.");
                }
        } catch (IOException e) {
            System.out.println("Error : Error reading file name: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
