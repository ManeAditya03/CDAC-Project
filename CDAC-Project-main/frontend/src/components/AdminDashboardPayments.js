import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';

const AdminDashboardPayments = (props) => {

    const [apiData, setApiData] = useState([]);
    const loggedInFlag = sessionStorage.getItem("user") != null;
    let user;

    useEffect(() => {

        user = JSON.parse(sessionStorage.getItem("user"));
        if (user == null) { user = { fullname: "", email: "", phone: "", dob: "", id: "" } }


        axios.get(`http://localhost:8080/bitcode/transaction`)
            .then(response => {
                setApiData(response.data)
            });
    }, []);

    var transactions = apiData.map(obj => {
        return (
            <tr>
                <td>{obj.fullname}</td>
                <td>{obj.amount}</td>
                <td>{obj.date}</td>
                <td>{obj.utrno}</td>
            </tr>
        );
    });

    return (
        <div class="adminContainer">
            <div class="adminSidebar">
                <ol>
                    <li><Link to="/adminDashboard" class="links">Pending Approvals</Link></li>
                    <li><Link to="/adminDashboardCourse" class="links">Course Stats</Link></li>
                    <li><Link to="/adminDashboardPayments" class="links active">Payments History</Link></li>
                    {loggedInFlag ?
                        <li><Link to="/logout" class="links">Logout</Link></li> : null
                    }
                </ol>
            </div>
            {loggedInFlag ?
                <div class="adminMainDiv">
                    <div className='purchaseApprovals'>
                        <h3>Orders Pending For Approvals</h3>
                        <table>
                            <tr>
                                <th>User's Name</th>
                                <th>Amount</th>
                                <th>Date</th>
                                <th>UtrNo</th>
                            </tr>
                            {transactions}
                        </table>
                    </div>
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
export default AdminDashboardPayments;