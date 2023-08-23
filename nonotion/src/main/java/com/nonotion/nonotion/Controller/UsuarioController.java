package com.nonotion.nonotion.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nonotion.nonotion.Model.Usuario;
import com.nonotion.nonotion.Repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/homeUsuario")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("homeUsuario");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @PostMapping("/homeUsuario")
    public String homeUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/telaInicial";
    }

    @GetMapping("/listaUsuario")
    public ModelAndView lista(Usuario usuario) {
        ModelAndView mv = new ModelAndView("listaUsuario");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        mv.addObject("usuario", usuarios);
        return mv;
    }

    @GetMapping("/loginUsuario")
    public String login() {
        return "loginUsuario";
    }

    @PostMapping("/loginUsuario")
    public String verificar(Usuario usuario) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getEmail().equalsIgnoreCase(usuario.getEmail())
                    && usuario1.getSenha().equalsIgnoreCase(usuario.getSenha())) {
                return "redirect:/telaInicial";
            }
        }
        return "redirect:/loginUsuario";
    }

}