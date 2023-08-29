import { Link } from 'react-router-dom';
import { useState, useEffect, useReducer, useCallback } from "react";
import axios from 'axios';

const Cart = (props) => {

    let user = JSON.parse(sessionStorage.getItem("user"));
    if (user == null) { user = { id: "" } }

    const [apiData, setApiData] = useState([]);

    const [, updateState] = useState();

    useEffect(() => {
        axios.get(`http://localhost:8080/bitcode/cart/${user.id}`)
            .then(response => { setApiData(response.data) });
    }, []);

    let cartTotal = 0;
    var userCart = apiData.map(obj => {
        cartTotal += obj.price;
        return (
            <tr>
                <td>{obj.courseName}</td>
                <td>{obj.author}</td>
                <td>{obj.price}</td>
                <td className='deleteCartItem'><img src='/Images/delete.png' onClick={() => {
                    axios.post('http://localhost:8080/bitcode/cart/remove', { cartId: user.id, courseId: obj.id })
                        .then(() => {
                            window.location.reload();
                        })
                        .catch(error => alert("Error in removing item from cart"));
                }} /></td>
            </tr>
        );
    });

    return (
        <div className="cartSection">
            <div className='cartContainer'>
                <table>
                    <tr>
                        <th>Course Name</th>
                        <th>Author</th>
                        <th>Price Per Item</th>
                        <th></th>
                    </tr>
                    {userCart}
                </table>
                <hr />
                <div className='cartTotal'>
                    <h1>Cart Total: {cartTotal}</h1>
                    <Link to="/paymentsPage"><button>Place Order</button></Link>
                </div>
            </div>
        </div >
    );
}
export default Cart;