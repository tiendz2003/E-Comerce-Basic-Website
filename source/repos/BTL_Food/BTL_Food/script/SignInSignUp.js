// lấy cái gom nhóm
var login = document.getElementsByClassName("login");
var register = document.getElementsByClassName("register");

// Ban đầu ẩn đăng ký 
register[0].style.display = 'none';

// Lấy các nút thay đổi
var switch_to_register = document.getElementById("switch_to_register");
var switch_to_login = document.getElementById("switch_to_login");

function noneblock(e) {
    login[0].style.display = 'none';
    register[0].style.display = 'none';

    if (e == switch_to_register) {
        register[0].style.display = 'block';
    } else if (e == switch_to_login) {
        login[0].style.display = 'block';
    } else {
        login[0].style.display = 'block';
    }
}

//Khi click dể chuyền form đăng nhập
switch_to_login.addEventListener('click', function () {
    noneblock(switch_to_login);
});

//Khi click dể chuyền form đăng kí
switch_to_register.addEventListener('click', function () {
    noneblock(switch_to_register);
});

var input = document.getElementsByTagName('input')
for (let i = 0; i < input.length; i++) {
    if (i != 10) {
        input[i].addEventListener("input", function () {
            let regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,}$/;
            //              chữ thường   chữ hoa    số        kí tự         kết hợp  độ dài 5->?
            let valid = regex.test(input[i].value);
            let pvalue = document.querySelectorAll("p." + input[i].className);

            if (valid) {
                pvalue[0].innerHTML = "";

            }
            else {
                pvalue[0].innerHTML = "Mật khẩu không hợp lệ (A-Z)(a-z)(0-9)(7 kt->)(!@#$%^&*())"
            }
        })
    }
    else {
        input[i].addEventListener('input', function () {
            let inputvalue = input[i - 1].value;
            let pvalue = document.querySelectorAll("p." + input[i].className);

            if (input[i].value == input[i - 1].value) {
                pvalue[0].innerHTML = "";

            }
            else {
                pvalue[0].innerHTML = "Mật khẩu không khớp"
            }
        })
    }
}
//Hàm gọi trang phù hợp
window.onload = function () {
    //Lấy Url hiện tại
    var URL = window.location.href;

    //Tạo một biểu thức chính quy để tìm kiếm tham số name trong URL:
    var regex = /[?&]name=(\w+)/;

    //Kiểm tra xem URL có chứa tham số name không:
    var match = URL.match(regex);

    //Nếu tham số name có giá trị là "DangKy", thì click vào phần tử switch_to_register:
    if (match) {
        if (match[1] == "DangKy") {
            switch_to_register.click();
        } else {
            if (match[1] == "DangNhap") {
                switch_to_login.click();
            }
        }
    }
}

/*document.addEventListener("DOMContentLoaded", function () {
    const switchToRegister = document.getElementById("switch_to_register");
    const switchToLogin = document.getElementById("switch_to_login");
    const loginForm = document.querySelector(".login");
    const registerForm = document.querySelector(".register");

    // Khi người dùng nhấn vào 'Đăng ký', ẩn form đăng nhập và hiển thị form đăng ký
    if (switchToRegister) {
        switchToRegister.addEventListener("click", function (event) {
            event.preventDefault();
            loginForm.style.display = "none";
            registerForm.style.display = "block";
        });
    }

    // Khi người dùng nhấn vào 'Đăng nhập', ẩn form đăng ký và hiển thị form đăng nhập
    if (switchToLogin) {
        switchToLogin.addEventListener("click", function (event) {
            event.preventDefault();
            registerForm.style.display = "none";
            loginForm.style.display = "block";
        });
    }
});*/
