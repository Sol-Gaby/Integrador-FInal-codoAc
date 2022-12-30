/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


nombreInput = document.getElementById('nombre')
apellidoInput = document.getElementById('apellido')
emailInput = document.getElementById('email')


function validar(){
    
    if (nombre.value===""){
        alert("Por favor, escribe el nombre del socio")
        nombre.focus();
        return false;
    }
    if (apellido.value === ""){
        alert("Por favor, escribe el apellido del socio")
        apellido.focus();
        return false;
    }
    if (email.value === ""){
        alert("Por favor, escribe el correo electrónico del socio")
        email.focus();
        return false;
    }
    

    swal('Listo! el socio fue registrado con éxito', 
    'Te llegará por correo electrónico información de cursos y capacitaciones proximos a dictarse', 'success');

    
}

