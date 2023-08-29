import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';
import { navigate, useNavigate } from "react-router-dom";

const ProfileEditInfo = (props) => {

    let user = JSON.parse(sessionStorage.getItem("user"));
    if (user == null) { user = { fullname: "", email: "", phone: "", dob: "" } }
    const [apiData, setApiData] = useState({ fullname: user.fullname, email: user.email, phone: user.phone, dob: user.dob });

    const handleChange = (event) => {
        const { name, value } = event.target
        setApiData({ ...apiData, [name]: value })

    }

    useEffect(() => {
        let flag = localStorage.getItem("Refresh");
        if (flag == "1") {
            localStorage.setItem("Refresh", "0");
            window.location.reload();
        }
    }, []);

    const savedata = (event) => {
        event.preventDefault();
        console.log(apiData);
        axios.put(`http://localhost:8080/bitcode/user/updateProfile/${user.id}`, apiData)
            .then(() => {
                alert("Profile updated successfully.");
                user.fullname = apiData.fullname;
                user.email = apiData.email;
                user.phone = apiData.phone;
                user.dob = apiData.dob;
                sessionStorage.setItem("user", JSON.stringify(user));
            })
            .catch(error => {
                alert("Invalid credentials."); console.log("Invalid credentials.")
            });
    }

    const loggedInFlag = sessionStorage.getItem("user") != null;

    return (
        <div class="profileContainer">
            <div class="profileSidebar">
                <ol>
                    <li><Link to="/" class="links">Home</Link></li>
                    <li><Link to="/profile" class="links active">Profile</Link></li>
                    <li><Link to="/profileCourses" class="links">My Courses</Link></li>
                    <li><Link to="/profileSettings" class="links">Settings</Link></li>
                    {loggedInFlag ?
                        <li><Link to="/logout" class="links">Logout</Link></li> : null
                    }
                </ol>
            </div>
            {loggedInFlag ?
                <div class="profileMainDiv">
                    <form method='PUT' onSubmit={savedata}>
                        <h3>Edit Information</h3>
                        <table>
                            <tr>
                                <td><label for="">Full Name</label></td>
                                <td><input type="text" name="fullname" value={apiData.fullname} onChange={handleChange} required /><br /></td>
                            </tr>

                            <tr>
                                <td><label for="">Date of birth</label></td>
                                <td><input type="date" name="dob" id="" value={apiData.dob} onChange={handleChange} required /><br /></td>
                            </tr>

                            <tr>
                                <td><label for="">Phone</label></td>
                                <td><input type="number" name="phone" id="" value={apiData.phone} onChange={handleChange} required /><br /></td>
                            </tr>

                            <tr>
                                <td><label for="">Email</label></td>
                                <td><input type="email" name="email" value={apiData.email} onChange={handleChange} required /><br /></td>
                            </tr>

                            <tr>
                                <td><input type="submit" value="Edit" /> <br /></td>
                            </tr>
                        </table>
                    </form>
                </div> :
                <div className='profileMainDiv'>
                    <form className='notLoggedIn'>
                        <h3>You are not logged in.</h3>
                        <Link to="/login" class="links">Click here to login</Link>
                    </form>
                </div>
            }
        </div >
    );
}
export default ProfileEditInfo;