document.getElementById("addSocioNombre").addEventListener("blur", validarNombre);
document.getElementById("addSocioApellidos").addEventListener("blur", validarApellidos);
document.getElementById("addSocioUsername").addEventListener("blur", validarEmail);
document.getElementById("addSocioTelefono").addEventListener("blur", validarTelefono);
document.getElementById("addSocioFechaAlta").addEventListener("blur", validarFechaAlta);

let error = document.querySelectorAll(".errorForm");
error.forEach(p => p.hidden = true);

function validarFormulario(event) {
    let resultado = true;

    resultado = validarNombre() &&
        validarApellidos() &&
        validarEmail() &&
        validarTelefono() &&
        validarFechaAlta();

        if (!resultado) {
            event.preventDefault();
        }
    return resultado;
}

function validarNombre() {
    let nombre = document.getElementById("addSocioNombre").value;
    if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/.test(nombre)) {
        document.getElementById("addSocioNombre").focus();
        document.getElementById("addSocioNombre").nextElementSibling.hidden = false;
        return false;
    }
    document.getElementById("addSocioNombre").nextElementSibling.hidden = true;
    return true;
}

function validarApellidos() {
    let apellidos = document.getElementById("addSocioApellidos").value;
    if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/.test(apellidos)) {
        document.getElementById("addSocioApellidos").focus();
        document.getElementById("addSocioApellidos").nextElementSibling.hidden = false;
        return false;
    }
    document.getElementById("addSocioApellidos").nextElementSibling.hidden = true;
    return true;
}

function validarEmail() {
    let email = document.getElementById("addSocioUsername").value;
    if (!/^\S+@\S+\.\S+$/.test(email)) {
        document.getElementById("addSocioUsername").focus();
        document.getElementById("addSocioUsername").nextElementSibling.hidden = false;
        return false;
    }
    document.getElementById("addSocioUsername").nextElementSibling.hidden = true;
    return true;
}

function validarTelefono() {
    let telefono = document.getElementById("addSocioTelefono").value;
    if (!/^\d{9}$/.test(telefono)) {
        document.getElementById("addSocioTelefono").focus();
        document.getElementById("addSocioTelefono").nextElementSibling.hidden = false;
        return false;
    }
    document.getElementById("addSocioTelefono").nextElementSibling.hidden = true;
    return true;
}

function validarFechaAlta() {
    let fechaAlta = document.getElementById("addSocioFechaAlta").value;
    let fechaActual = new Date();
    fechaAlta = new Date(fechaAlta);
    if (!fechaAlta || fechaAlta>fechaActual) {
        document.getElementById("addSocioFechaAlta").focus();
        document.getElementById("addSocioFechaAlta").nextElementSibling.hidden = false;
        return false;
    }
    document.getElementById("addSocioFechaAlta").nextElementSibling.hidden = true;
    return true;
}

let formulario = document.getElementById("formularioSocioAdmin");
formulario.addEventListener("submit", validarFormulario);