import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';

const AdminDashboardCourse = (props) => {

    const loggedInFlag = sessionStorage.getItem("user") != null;

    const [courseCount1, setCourseCount1] = useState("");
    const [courseCount2, setCourseCount2] = useState("");
    const [courseCount3, setCourseCount3] = useState("");

    useEffect(() => {
        axios.get(`http://localhost:8080/bitcode/courses/userCount/1`)
            .then(response => {
                setCourseCount1(response.data)
            });

        axios.get(`http://localhost:8080/bitcode/courses/userCount/2`)
            .then(response => {
                setCourseCount2(response.data)
            });

        axios.get(`http://localhost:8080/bitcode/courses/userCount/3`)
            .then(response => {
                setCourseCount3(response.data)
            });
    }, []);

    return (
        <div class="adminContainer">
            <div class="adminSidebar">
                <ol>
                    <li><Link to="/adminDashboard" class="links">Pending Approvals</Link></li>
                    <li><Link to="/adminDashboardCourse" class="links active">Course Stats</Link></li>
                    <li><Link to="/adminDashboardPayments" class="links">Payments History</Link></li>
                    {loggedInFlag ?
                        <li><Link to="/logout" class="links">Logout</Link></li> : null
                    }
                </ol>
            </div>
            {loggedInFlag ?
                <div class="courseContainer">
                    <h3>Courses</h3>
                    <div class="courseCardContainer">
                        <div class="courseCard">
                            <img src="/Images/mysql.svg" height='100px' width='100px' />
                            <div className='courseCardInfo'>
                                <h3>MySQL</h3>
                                <p>Subscribers: {courseCount1}</p>
                                <Link to="/addToCourse" onClick={() => localStorage.setItem("CourseName", "MySQL")} class="buy">Add New Chapter</Link>
                            </div>
                        </div>
                        <div class="courseCard">
                            <img src="/Images/mysql.svg" height='100px' width='100px' />
                            <div className='courseCardInfo'>
                                <h3>HTML CSS</h3>
                                <p>Subscribers: {courseCount2}</p>
                                <Link to="/addToCourse" onClick={() => localStorage.setItem("CourseName", "HTML CSS")} courseName="HTML CSS" class="buy">Add New Chapter</Link>
                            </div>
                        </div>
                        <div class="courseCard">
                            <img src="/Images/mysql.svg" height='100px' width='100px' />
                            <div className='courseCardInfo'>
                                <h3>JavaScript</h3>
                                <p>Subscribers: {courseCount3}</p>
                                <Link to="/addToCourse" onClick={() => localStorage.setItem("CourseName", "JavaScript")} courseName="JavaScript" class="buy">Add New Chapter</Link>
                            </div>
                        </div>
                    </div>
                </div> :
                <div className='profileMainDiv'>
                    <form className='notLoggedIn'>
                        <h3>You are not logged in.</h3>
                        <Link to="/login" class="links">Click here to login?</Link>
                    </form>
                </div>
            }
        </div >
    );
}
export default AdminDashboardCourse;