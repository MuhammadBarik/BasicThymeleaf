/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Takehome1.Takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LENOVO
 */
@Controller
public class controller {
    @RequestMapping ("/login")
    public String getLogin (@RequestParam(value="inputNama") String nama,
                            @RequestParam(value="inputTanggal") String date,
                            @RequestParam(value="inputFile") MultipartFile file,
                            Model model)
    throws IOException{
        byte[] img = file.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("TransferNama", nama);
        model.addAttribute("TransferTanggal", date);
        model.addAttribute("TransferFile", imglink);
        return "Tampilan";
    }   
}
