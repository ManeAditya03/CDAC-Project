import { Link } from 'react-router-dom';

const CourseChapters = (props) => {
    return (
        <div class="courseChapters">
            <ol>
                <li><Link to="/" class="links">Home</Link></li>
                <li><Link to="/profile" class="links active">Profile</Link></li>
                <li><Link to="/profile/courses" class="links">My Courses</Link></li>
                <li><Link to="/profile/settings" class="links">Settings</Link></li>
            </ol>
        </div>
    );
}
export default CourseChapters;