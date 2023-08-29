import { Link, Outlet } from 'react-router-dom';
import MySQLChapters from '../courseContents/MySQL/Chapters';
import HtmlCssChapters from '../courseContents/HTMLCSS/Chapters';
import JsChapters from '../courseContents/JavaScript/Chapters';
import { useState, useEffect } from "react";
import axios from 'axios';

const CourseContent = (props) => {

    const [apiData, setApiData] = useState({});
    useEffect(() => {
        const courseId = localStorage.getItem("CourseId");
        axios.get(`http://localhost:8080/bitcode/courses/${courseId}`)
            .then(response => { setApiData(response.data) });
    }, []);

    if(apiData.id == "1"){
        return (
            <div className='courseContentPanel'>
                <div className='courseContentHeading'>
                    <img src={apiData.imagePath} alt='Course Image' height='100px' width='100px' />
                    <h3>{apiData.courseName}</h3>
                </div>
                <div className='courseContent'>
                    <MySQLChapters />
                    <Outlet/>
                </div>
            </div>
        );
    }
    if(apiData.id == "2"){
        return (
            <div className='courseContentPanel'>
                <div className='courseContentHeading'>
                    <img src={apiData.imagePath} alt='Course Image' height='100px' width='100px' />
                    <h3>{apiData.courseName}</h3>
                </div>
                <div className='courseContent'>
                    <HtmlCssChapters />
                    <Outlet/>
                </div>
            </div>
        );
    }
    if(apiData.id == "3"){
        return (
            <div className='courseContentPanel'>
                <div className='courseContentHeading'>
                    <img src={apiData.imagePath} alt='Course Image' height='100px' width='100px' />
                    <h3>{apiData.courseName}</h3>
                </div>
                <div className='courseContent'>
                    <JsChapters />
                    <Outlet/>
                </div>
            </div>
        );
    }
}
export default CourseContent;