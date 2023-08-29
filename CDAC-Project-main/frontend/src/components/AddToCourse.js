import React, { useState, useRef, useEffect } from 'react';
import JoditEditor from 'jodit-react';
import { Link } from 'react-router-dom';

const AddToCourse = (props) => {

    const editor = useRef(null);
    const [content, setContent] = useState('');
    let courseName = "";

    const [apiData, setApiData] = useState({ chapterName: "" })

    const handleChange = (event) => {
        const { name, value } = event.target
        setApiData({ ...apiData, [name]: value })

    }

    const loggedInFlag = sessionStorage.getItem("user") != null;

    useEffect(() => {
        courseName = localStorage.getItem("CourseName");
        console.log(courseName);
    });

    return (
        <div className='addToCourse'>
            {loggedInFlag ?
                <div className='addToCourseContainer'>
                    <Link to="/adminDashboard" className="adminDashboardLink">Go To Dashboard</Link>
                    <h3>{courseName}</h3>
                    <input type="text" name='chapterName' placeholder="New Chapter's name" onChange={handleChange} />
                    <JoditEditor
                        className='joditEditor'
                        name='chapterContent'
                        ref={editor}
                        value={content}
                        onChange={newContent => { setContent(newContent) }}
                    />
                </div> :
                <form className='notLoggedIn'>
                    <h3>You are not logged in.</h3>
                    <Link to="/login" class="links">Click here to login</Link>
                </form>
            }
        </div>
    );

}
export default AddToCourse;