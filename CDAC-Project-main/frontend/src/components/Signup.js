import { Link } from 'react-router-dom';
import { useState } from "react";
import axios from 'axios';
import { navigate, useNavigate } from "react-router-dom";

const Signup = (props) => {

    const [apiData, setApiData] = useState({ fullname: "", email: "", phone: "",  gender: "", dob: "", username: "", password: ""});

    let navigate = useNavigate();

    const savedata = (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/bitcode/signup', apiData)
            .then(() => {
                alert("User registered successfully, login to continue.");
                navigate("/login");
            })
            .catch((error)=> {console.log(error)});
    }

    const handleChange = (event) => {
        const { name, value } = event.target
        setApiData({ ...apiData, [name]: value })

    }

    return (
        <>
            <div id="signupContainer">
                <form method="POST" onSubmit={savedata} class="signup-form">
                    <p>Register Yourself</p>
                    <div class="row">
                        <div class="sub-row" id="wide">
                            <label for="">Full Name</label>
                            <input type="text" name="fullname" onChange={handleChange} placeholder="Alex Grey" required />
                        </div>
                    </div>
                    <div class="row">
                        <div class="sub-row">
                            <label for="">User Name</label>
                            <input type="text" name="username" id="" onChange={handleChange} placeholder="4 Letters" required />
                        </div>
                        <div class="sub-row">
                            <label for="">Password</label>
                            <input type="password" name="password" id="" onChange={handleChange} placeholder="*******" required />
                        </div>
                    </div>
                    <div class="row">
                        <div class="sub-row" id="wide">
                            <label for="">Email</label>
                            <input type="email" name="email" onChange={handleChange} placeholder="alex@gmail.com" required />
                        </div>
                    </div>
                    <div class="row">
                        <div class="sub-row">
                            <label for="">Phone</label>
                            <input type="number" name="phone" id="" onChange={handleChange} placeholder="+00 000 000 0000" required />
                        </div>
                        <div class="sub-row">
                            <label for="">Gender</label>
                            <div class="radio">
                                <input type="radio" name="gender" id="" value="MALE" onChange={handleChange} />
                                <label for="">Male</label>
                                <input type="radio" name="gender" id="" value="FEMALE" onChange={handleChange} />
                                <label for="">Female</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="sub-row">
                            <label for="">Date of birth</label>
                            <input type="date" name="dob" id="" onChange={handleChange} required /></div>
                        <div class="sub-row">

                        </div>
                    </div>
                    <div class="row submit">
                        <input type="submit" value="Register" id="submit" />
                    </div>
                    <Link to="/login" class="loginInsted">Login Instead?</Link>
                </form>
            </div>

        </>
    );
}
export default Signup;