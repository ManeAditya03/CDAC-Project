import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';
import { useNavigate } from "react-router-dom";

const Login = (props) => {

    useEffect(() => {
        if (sessionStorage.getItem("user") != null) {
            if (window.confirm("A user is already logged in. Do you want to logout?") === false) {
                navigate("/");
            }
            else{
                sessionStorage.clear();
            } 
        }
    }, []);

    const [apiData, setApiData] = useState({ username: "", password: "" });

    let navigate = useNavigate();

    const savedata = (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/bitcode/signin', apiData)
            .then(
                response => {
                    sessionStorage.setItem("token", "Bearer " + response.data.jwt);
                    sessionStorage.setItem("user", JSON.stringify(response.data.user));
                    localStorage.setItem("Refresh", "1");

                    if (response.data.user.role.includes('ROLE_ADMIN')) {
                        navigate('/adminDashboard');
                    } else {
                        navigate("/profile");
                    }
                }
            )
            .catch(error => alert("Invalid credentials."));
    }

    const handleChange = (event) => {
        const { name, value } = event.target
        setApiData({ ...apiData, [name]: value })

    }

    return (
        <>
            <div id="loginContainer">
                <form method="POST" onSubmit={savedata} class="login-form">
                    <div class="title">
                        <p>Login</p>
                    </div>
                    <div class="username">
                        <input type="text" name="username" id="username" onChange={handleChange} placeholder="Username" required />
                    </div>
                    <div class="pass">
                        <input type="password" name="password" id="pass" onChange={handleChange} placeholder="Password" required />
                    </div>
                    <div class="remember-me">
                        <input type="checkbox" name="remember" id="checkbox" />
                        <label for="checkbox">Remember Me</label>
                    </div>
                    <div class="forgot-pass">
                        <Link to="/">Forgot Password?</Link>
                    </div>
                    <div class="login-button">
                        <input id="submit" type="submit" value="Login" />
                    </div>
                    <div class="signup-link">
                        <Link to="/signup">Signup for New Account Here</Link>
                    </div>
                </form>
            </div>
        </>
    );
}
export default Login;