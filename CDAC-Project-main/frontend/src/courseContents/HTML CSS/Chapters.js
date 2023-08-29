import { Link } from 'react-router-dom';

const Chapters = () => {
    return (
        <div className="courseChapters">
            <ol>
                <li><Link to="chapter1" class="links">1. Types Of Primary Keys</Link></li>
                <li><Link to="chapter2" class="links">2. Types Of MySQL Queries</Link></li>
                <li><Link to="chapter3" class="links">3. DataBase Operations</Link></li>
                <li><Link to="chapter4" class="links">4. Managing Tables</Link></li>
                <li><Link to="chapter5" class="links">5. MySQL Constraints</Link></li>
            </ol>
        </div>
    );
}

export default Chapters;