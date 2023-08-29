import { Link } from 'react-router-dom';

const Chapters = () => {
    return (
        <div className="courseChapters">
            <ol>
                <li><Link to="chapter1" class="links">1. Introduction to HTML5</Link></li>
                <li><Link to="chapter2" class="links">2. Multimedia and embedding</Link></li>
                <li><Link to="chapter3" class="links">3. CSS Styling the web</Link></li>
                <li><Link to="chapter4" class="links">4. Adding vector graphics to the web</Link></li>
                <li><Link to="chapter5" class="links">5. CSS layouts</Link></li>
            </ol>
        </div>
    );
}

export default Chapters;