package validaciones;

import jakarta.servlet.http.HttpServletRequest;

public class validacioncontact {

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validateEmail(String email) {
        return email != null && email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }

    public static boolean validatePhone(String phone) {
        return phone != null && phone.matches("^\\d{9}$");
    }

    public static boolean validateMessage(String message) {
        return message != null && !message.trim().isEmpty();
    }

    public static boolean processForm(HttpServletRequest request) {
        String name = request.getParameter("nombre");
        String email = request.getParameter("correo");
        String phone = request.getParameter("telefono");
        String message = request.getParameter("comentario");

        boolean isValid = true;

        if (!validateName(name)) {
            request.setAttribute("nameError", "Se requiere un nombre válido");
            isValid = false;
        }

        if (!validateEmail(email)) {
            request.setAttribute("emailError", "Se requiere un correo electrónico válido");
            isValid = false;
        }

        if (!validatePhone(phone)) {
            request.setAttribute("phoneError", "El número de teléfono debe contener 9 dígitos");
            isValid = false;
        }

        if (!validateMessage(message)) {
            request.setAttribute("messageError", "Se requiere un mensaje");
            isValid = false;
        }

        return isValid;
    }
}
