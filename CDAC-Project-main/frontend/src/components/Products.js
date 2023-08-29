import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';
import { useNavigate } from "react-router-dom";

const Products = (props) => {

    const [apiData, setApiData] = useState([]);
    const [purcahsedCourses, setPurcahsedCourses] = useState([]);
    let navigate = useNavigate();

    let user;
    let myCourseIds = [];
    let cartApi = { cartId: "", courseId: "" }

    const setMyCourseIds = (value, index, array) => { myCourseIds.push(value.id); }

    useEffect(() => {

        user = JSON.parse(sessionStorage.getItem("user"));
        if (user == null) { user = { fullname: "", email: "", phone: "", dob: "", id: "" } }


        axios.get(`http://localhost:8080/bitcode/user/userCourses/${user.id}`)
            .then(response => {
                setPurcahsedCourses(response.data)
            });

        axios.get('http://localhost:8080/bitcode/courses')
            .then(response => {
                setApiData(response.data)
            });
    }, []);

    purcahsedCourses.forEach(setMyCourseIds);

    const addToCart = () => {
        axios.post('http://localhost:8080/bitcode/cart/add', cartApi)
            .then(response => alert(response.data));
    }

    var courseCards = apiData.map(obj => {
        let goToCourseUrl = "";
        if(obj.id == "1") {goToCourseUrl = "mysqlcourse/chapter1"}
        if(obj.id == "2") {goToCourseUrl = "htmlcsscourse/chapter1"}
        if(obj.id == "3") {goToCourseUrl = "jscourse/chapter1"}

        return (
            <div class="product">
                <div class="image">
                    <img src={obj.imagePath} alt="" />
                </div>
                <div class="description">
                    <h3>{obj.courseName}</h3>
                    <p>{obj.author}</p>
                    <h2 class="price">{obj.price}</h2>
                    <Link to="/coursedetail" id={obj.id} onClick={() => localStorage.setItem("CourseId", obj.id)} class="buy">View</Link>
                    {myCourseIds.includes(obj.id) ?
                        <a href={goToCourseUrl} className='add' onClick={() => localStorage.setItem("CourseId", obj.id)}>Go To Course</a> :
                        <a onClick={() => {
                            user = JSON.parse(sessionStorage.getItem("user"));
                            cartApi.cartId = user.id;
                            cartApi.courseId = obj.id;
                            addToCart();
                        }} class="add">Add to Cart</a>
                    }
                </div>
            </div>
        );
    });

    return (
        <>
            <div class="productSection1">
                <div class="main_container">
                    <div class="vertical_sec">
                        <div class="horizontal_sec">
                            <div class="box" id="box1">
                                <h3>Data Science</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                            <div class="box" id="box2">
                                <h3>Business</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                        </div>
                        <div class="horizontal_sec">
                            <div class="box" id="box3">
                                <h3>Computer Science</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                            <div class="box" id="box4">
                                <h3>Information Tech</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                        </div>
                    </div>
                    <div class="vertical_sec">
                        <div class="box" id="box5">
                            <h3>Personal Development</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea! Cum
                                sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="productSection2">
                <div class="productGrid">
                    {courseCards}
                </div>
            </div>
        </>
    );
}
export default Products;