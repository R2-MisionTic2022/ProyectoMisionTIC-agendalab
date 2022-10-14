const login = () => {
    const username = document.getElementById('username').value;
    const contrasena = document.getElementById('contrasena').value;

    if (username == "") {
        showError("Usuario es requerido");
        return;
    }

    if (contrasena == "") {
        showError("Contraseña es requerida");
        return;
    }


    const body = {
        "username": username,
        "contrasena": contrasena
    };
    postToLogin(body);

};

const postToLogin = async (bodyObject) => {
    const url = "/api/login";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const user = await response.json();

        localStorage.setItem("loggedUser", JSON.stringify(user));

        alert("Bienvenido " + user.username, "success");

        await new Promise(r => setTimeout(r, 2000));

        window.location.href = "/admin";

    } else {
        const message = await response.text();
        showError(message);
    }
};

const showError = (message) => {
    alert(message, "danger");
}

const alert = (message, type) => {
    document.getElementById("errorBox").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
}
