import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';

const AdminDashboard = (props) => {

    const loggedInFlag = sessionStorage.getItem("user") != null;

    return (
        <div class="adminContainer">
            <div class="adminSidebar">
                <ol>
                    <li><Link to="/adminDashboard" class="links active">Pending Approvals</Link></li>
                    <li><Link to="/adminDashboardCourse" class="links">Course Stats</Link></li>
                    <li><Link to="/adminDashboardPayments" class="links">Payments History</Link></li>
                    {loggedInFlag ?
                        <li><Link to="/logout" class="links">Logout</Link></li> : null
                    }
                </ol>
            </div>
            {loggedInFlag ?
                <div class="adminMainDiv">
                    <div className='purchaseApprovals'>
                        <h3>Orders Pending For Approvals</h3>
                        <ul>
                            <li>No Pending Orders For Approval!</li>
                            {/* <li><pre>Username : UTR No  <button onClick={() => { }}>Approve</button>  <button onClick={() => { }}>Reject</button></pre></li>
                            <li><pre>Username : UTR No  <button onClick={() => { }}>Approve</button>  <button onClick={() => { }}>Reject</button></pre></li>
                            <li><pre>Username : UTR No  <button onClick={() => { }}>Approve</button>  <button onClick={() => { }}>Reject</button></pre></li> */}
                        </ul>
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
export default AdminDashboard;