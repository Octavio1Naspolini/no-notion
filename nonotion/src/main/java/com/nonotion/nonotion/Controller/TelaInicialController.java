package com.nonotion.nonotion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelaInicialController {

    @GetMapping("/telaInicial")
    public String home() {
        return "telaInicial";
    }
}
