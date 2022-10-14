const loadUserConfig = () => {

    const loginLi1 = document.getElementById("login-link1");
    //const loginLi2 = document.getElementById("login-link2");
    //const loginLi3 = document.getElementById("login-link3");

    const logoutLi1 = document.getElementById("logout-link1");
    const logoutLi2 = document.getElementById("logout-link2");
    const logoutLi3 = document.getElementById("logout-link3");
    const logoutLi4 = document.getElementById("logout-link4");

    const user = localStorage.getItem("loggedUser");
    
   if (user == undefined) {
        loginLi1.style.display = 'block';
        //loginLi2.style.display = 'block';
        //loginLi3.style.display = 'block';

        logoutLi1.style.display = 'none';
        logoutLi2.style.display = 'none';
        logoutLi3.style.display = 'none';
        logoutLi4.style.display = 'none';
    } else {

        loginLi1.style.display = 'none';
        //loginLi2.style.display = 'none';
        //loginLi3.style.display = 'none';

        logoutLi1.style.display = 'block';
        logoutLi2.style.display = 'block';
        logoutLi3.style.display = 'block';
        logoutLi4.style.display = 'block';

        const userInfo = JSON.parse(user);
        document.getElementById("user-fullname").innerText = userInfo.nombres
    } 
};

const isAdmin = () => {
    const user = localStorage.getItem("loggedUser");
    if (user == undefined) {
        return false;
    }

    const userInfo = JSON.parse(user);
    return userInfo.admin;
};

loadUserConfig();

const logout = () => {
    localStorage.removeItem("loggedUser");

    loadUserConfig();
};