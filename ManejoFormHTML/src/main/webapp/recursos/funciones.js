function validarForma(forma) {
    var usuario = forma.usuario;
    if (usuario.value === "" || usuario.value == "Escribir usuario") {

        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }

    var pass = forma.password;
    if (pass.value === "" || pass.value.length < 3) {

        alert("Debe proporcionar un password mayor a 3");
        pass.focus();
        pass.select();
        return false;
    }

    var tecnologias = forma.tecnologia;
    var checkSelected = false;

    for (var i = 0; i < tecnologias.length; i++) {
        if (tecnologias[i].checked) {
            checkSelected = true;
        }
    }

    if (!checkSelected) {

        alert("Debe seleccionar una tecnologia");
        return false;
    }
    
    var generos = forma.genero;
    var radioSelected=false;
    
    for (var i = 0; i < generos.length; i++) {
        if (generos[i].checked) {
            radioSelected = true;
        }
    }
    
    if (!radioSelected) {

        alert("Debe seleccionar un genero");
        return false;
    }
    
    var ocupacion= forma.ocupacion;
    if(ocupacion.value ===""){
        
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
    //Formulario valido
    alert("Formulario valido, enviado datos al servidor");
    return true;
}

