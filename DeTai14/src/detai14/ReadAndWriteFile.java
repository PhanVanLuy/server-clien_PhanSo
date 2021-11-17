/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detai14;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ReadAndWriteFile {
    private static String myUrlFile = "C:\\Users\\PHAN VAN LUY\\Documents\\NetBeansProjects\\DeTai14.1\\phanso.dat";
    public String ReadFile()
    {
        String myData = "";
        try {
            File f = new File(myUrlFile);
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                myData+= line;
            }
            ThuatToanDES giaiMa = new ThuatToanDES();
            //System.out.println("myDataDocFile" + myData);
            String newMyData= giaiMa.GiaiMaDES(myData);
            myData = newMyData;
             fr.close();
             br.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể đọc file");
        }
        return myData;
    }
    
    public int WriteFile(String myData)
    {
        try {
            File f = new File(myUrlFile);
            FileWriter fw = new FileWriter(f,true);
            ThuatToanDES maHoa = new ThuatToanDES();
            String dataNew = maHoa.MaHoaDES(","+myData);
            fw.write(dataNew);
            fw.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể ghi vào file");
            return 0;
        }
        return 1;
    }
}
