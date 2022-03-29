/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author ue0100066h
 */
@RestController
@RequestMapping("/login")
public class apiController {
 
    @PostMapping("/")
    public Map<String, String> api(@RequestHeader("Authorization") String authorization) {
        Logger logger = LoggerFactory.getLogger(apiController.class);
        logger.info("*************INGRESA a la API de logueo*************:");
        logger.info("user name and password Encoded: "+authorization.substring(6));
        
        byte[] decodedBytes = Base64.getDecoder().decode(authorization.substring(6));
        String decodedString = new String(decodedBytes);
        logger.info("user name and password Dencoded: "+decodedString);

        // volpay tomaria user:pass y generaria la trama JSON de respuesta 
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("status", "Operacion exitosa");
            map.put("folio", "839499020210126160854");
            map.put("token", "eyJjdHkiOiJKV1QiLCJhbGciOiJSU0EtT0FFUCIsImVuYyI6IkExMjhDQkMtSFMyNTYifQ.NXLW0TGAJnFsTSrFZO2GdNw_H3itHtbOyNhCJMASn6pOPmJVnBJ8yLURapH0DNxQ3IhIGYjBix03n8r-ygzlUgPi-U7jsCN7qeJuJJE_vBGLI0AII42X6kQDR4CF0cJCanLOWT0aQvIWleBfNQ-2pBxYYRwB9FcWhaGj7Iw8GJplo3pecvV8gRwztQkUsHUHuxnnquRC9UxTG6EJ1yriHi1rCSaeEnXQbdvIloDrMOvFOwxSwbLxvfCA1bLXy6Dg1kKs1ZN07ixq-7a_8nzXDX80srFvY0HoptvGg2UIUTXI3v6lq3q_nIkv7zzG5iIQzFDV-hxsBNcNWJ2rhBOQWQ.4AXL0kDgZ3ngAqClT2wgsQ.mJWCLWe9zsJbx58FfqbNJZcwzume-_sbBsIScy__DuzwAM28rUqVI605KzFyFQUuYMa3sodHITGJaQ3KFenVc8mVCCjb84U_TvdZCPmv5MMsygZ17iKiXT8VToY1d-HJyIBOJ8Ax3d9ZnJjpf_ToHhwOO6n_SCUniUmXoqJm9ur5nrFhN-2-REaioe1M3UoBAH_b9vLyenVaTNHZxQwx73GfiXmV6DObZMihk8gP4e3vNVojnPzxi5-d5tvnTWdyEzC1aiJ8yOUsum_KRKWTO37wq9BgGnOts8BHmlJZPhL4wUoUP8M79SRofXRs_JkvYRaasPvI6yVPdhS0kwTvWcCoNyaM-xSAOMpH-geHCbhKXO0RIs1aIUrUZbjAA-ZMl8IQnYeS4JAsJuVIfuJ3m9u3Z2A7asj9Otv-RYtPr17AankBo_HhCo2kuLtbZr1HE0eVmintIiT5QaYd6XvHqB_3GWjtuny_w04qv2p8GrbN_dzLv5y4_CSrQ-1wrfF8CV9DsJ5bW1maLTlB-sOr79R1A0JT8058SHMRUKGUD10YnuZwBpg934Kbp1RzhYVmWDhxFHdRehGM5H8SMtEXBeGkJ3ObQPsWaAzSDWvKijFvDvikphQ6-ekS50jO2-70-8uphobTjNe7m08fL2OpBrG9q80Byfcg1CvpS1UDikUMnU_rkFbQguT8-zuSPyhw5WzO0e_MXAFFfrSJDw6nuylfLpJUVZSH5zXlrpyK-Btz_3wzFboQkSeS5xhtAberuj6NObkUFfGCFaNGGdCpXA.9FxWqqzahlfvISw_PGZYmg");
            
            logger.info("JSON generado exitosamente!\n"+map);
            return map;
        } 
        catch (Exception e) {
            logger.error("Existe un problema "+e);
            return null;
        }

    }
}
