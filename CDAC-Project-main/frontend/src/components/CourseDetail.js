import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';

const CourseDetail = (props) => {

    const [apiData, setApiData] = useState([]);
    const [courseDetails, setCourseDetails] = useState([]);
    useEffect(() => {
        const courseId = localStorage.getItem("CourseId");
        axios.get(`http://localhost:8080/bitcode/courses/${courseId}`)
            .then(response => { setApiData(response.data) });

        axios.get(`http://localhost:8080/bitcode/courseDetails/${courseId}`)
            .then(response => { setCourseDetails(response.data) });
    }, []);

    let count = 0;
    var courseChapters = courseDetails.map(obj => {
        count++;
        return (
            <li>{count}. {obj.chapterName}</li>
        );
    });

    return (
        <div className='courseContentPanel'>
            <div className='courseContentHeading'>
                <img src='/Images/mysql.svg' alt='MySQL Course' height='100px' width='100px' />
                <h3>{apiData.courseName}</h3>
            </div>
            <h4>Course Contents :</h4>
            <p>{apiData.description}</p>
            <div className='courseContentChaptersList'>
                <ol>
                    {courseChapters}
                </ol>
            </div>
        </div>
    );
}
export default CourseDetail;