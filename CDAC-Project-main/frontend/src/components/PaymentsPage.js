import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';
import { navigate, useNavigate } from "react-router-dom";

const PaymentsPage = (props) => {
    const [apiData, setApiData] = useState({ utrno: "", amount: "", userid: "" });

    useEffect(() => {
        let user = JSON.parse(sessionStorage.getItem("user"));
        if (user == null) { user = { fullname: "", email: "", phone: "", dob: "", id:"" } }

        axios.get(`http://localhost:8080/bitcode/cart/cartTotal/${user.id}`)
            .then( response => {
                setApiData({ ...apiData, ["amount"]: response.data, ["userid"]: user.id })
            });
    }, []);

    const handleChange = (event) => {
        const { name, value } = event.target;
        setApiData({ ...apiData, [name]: value })
    }

    const orderPlaced = () => {
        axios.post('http://localhost:8080/bitcode/orders/placeOrder', apiData)
            .then(() => {
                navigate("/profileCourses");
                alert("Order placed successfully");
            })
            .catch((error) => { console.log(error) });
    }

    let navigate = useNavigate();

    return (
        <div className='paymentsSection'>
            <div className='paymentsContainer'>
                <img src='/Images/paymentQR.jpg'></img>
                <h1>Payment Amount: {apiData.amount}</h1>
                <input type='number' name='utrno' placeholder='UTR Number' onChange={handleChange} required />
                <button onClick={orderPlaced}>Submit</button>
            </div>
        </div>
    );
}
export default PaymentsPage;