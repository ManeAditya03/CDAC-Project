const About = (props) => {
    return (
        <>

            <div id="aboutContainer">
                <h2>About the Company</h2>
                <p id="about">The Title Project is one of those "What I wish I had when I was learning" resources.
                    Not everyone has access to a computer science education or the funds to attend
                    an intensive coding school and neither of those is right for everyone anyway.
                    This project is designed to fill in the gap for people who are trying to hack
                    it on their own but still want a high quality education. </p>


                <h2>Our Beliefs</h2>

                <div class="beliefs">
                    <div class="image">
                        <img src="/Images/belief-image1.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Education should be free and accessible </h3>
                        <p>This curriculum itself is free and we tried to link to resources that are
                            themselves free so anyone in the world can use them. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="/Images/belief-image2.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>You learn best by actually building </h3>
                        <p>The Odin Project curriculum is full of projects that will help you build a
                            strong portfolio of work on GitHub to fill out your resume. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="/Images/belief-image3.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Motivation is fueled by working with others </h3>
                        <p>We're committed to connecting students together so they can stay motivated
                            and learn faster. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="/Images/belief-image4.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Open source is best </h3>
                        <p>Our curriculum and website are available on GitHub and we encourage students
                            to actually contribute to the project itself! </p>
                    </div>
                </div>
            </div>
        </>
    );
}
export default About;