import { Link } from 'react-router-dom';
import { useState, useEffect, useReducer } from "react";
import { navigate, useNavigate } from "react-router-dom";

const ProfileEditInfo = (props) => {
    useEffect(() => {
        if (sessionStorage.getItem("user") == null) {
            if (window.confirm("You need to login, to access this page.") == true) {
                navigate("/login");
            }
            else{
                navigate("/");
            } 
        }
    },[]);

    let navigate = useNavigate();
    let user = JSON.parse(sessionStorage.getItem("user"));

    const logoutUser = ()=> {
        sessionStorage.clear(); navigate("/"); localStorage.setItem("Refresh", "1"); alert("Logged out successfully.");
    }

    return (
        <div class="profileContainer">
            <div class="profileSidebar">
                <ol>
                    <li><Link to="/" class="links">Home</Link></li>
                    <li><Link to="/profile" class="links">Profile</Link></li>
                    <li><Link to="/profileCourses" class="links">My Courses</Link></li>
                    <li><Link to="/profileSettings" class="links">Settings</Link></li>
                    {sessionStorage.getItem("user") != null ?
                            <li><Link to="/logout" class="links active">Logout</Link></li> : null
                        }
                </ol>
            </div>
            <div class="profileMainDiv">
                <form onSubmit={logoutUser} id="logout">
                    <h3>Logout ?</h3>
                    <table>
                        <tr>
                            <td><input type="submit" value="Yes" /> <br /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div >
    );
}

export default ProfileEditInfo;