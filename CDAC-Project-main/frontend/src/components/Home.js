import { useEffect } from 'react';
import { Link } from 'react-router-dom';

const Home = (props) => {

    useEffect(() => {
        let flag = localStorage.getItem("Refresh");
        if (flag == "1") {
            localStorage.setItem("Refresh", "0");
            window.location.reload();
        }
    }, []);

    return (
        <>
            <header>
                <h2>Your Career In Web Development Starts Here</h2>
                <p>Our full stack curriculum is supported by a passionate open source community.</p>
                <p>Remove your fresher's tag, join Industrial Training program now.</p>
                <Link to="/products" class="button">Let's Get Started</Link>
            </header>

            <main>
                <div id="section0">
                    <img src="/Images/headerImg.svg" alt="header" />
                </div>
                <div id="section1">
                    <div class="section1-heading" id="products">
                        <h2>Product Description</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut itaque
                            rem nulla quas incidunt sint Id quo sed iure iste ipsam, vitae accusantium
                            voluptates iusto libero doloribus perferendis.</p>
                    </div>
                    <div class="card-view">
                        <div class="card">
                            <img src="/Images/book.svg" alt="Learn" />
                            <h2>Learn</h2>
                            <p>Learn from a curriculum with the best curated online tutorials, blogs, and courses.</p>
                        </div>
                        <div class="card">
                            <img src="/Images/pc.svg" alt="Build" />
                            <h2>Build</h2>
                            <p>Build dozens of portfolio-worthy projects along the way, from simple scripts to full programs and
                                deployed websites.</p>
                        </div>
                        <div class="card">
                            <img src="/Images/connect.svg" alt="Connect" />
                            <h2>Connect</h2>
                            <p>You're not alone. Learn and get help from our friendly community of beginner and experienced
                                developers.</p>
                        </div>
                    </div>
                </div>
                <div class="productSection01">
                    <img src="/Images/companies.png" alt="" width="80%" />
                </div>
            </main>
        </>
    );
}
export default Home;
