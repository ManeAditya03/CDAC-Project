import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './components/Home';
import About from './components/About';
import Login from './components/Login';
import Signup from './components/Signup';
import Products from "./components/Products";
import ProfileEditInfo from "./components/ProfileEditInfo";
import ProfileCourses from "./components/ProfileCourses";
import ProfileSettings from "./components/ProfileSettings";
import CourseContent from "./components/CourseContent";
import CourseDetail from "./components/CourseDetail";
import Logout from "./components/Logout";
import Cart from "./components/Cart";
import AdminDashboard from "./components/AdminDashboard";
import AdminDashboardCourse from "./components/AdminDashboardCourse";
import AdminDashboardPayments from "./components/AdminDashboardPayments";
import AddToCourse from "./components/AddToCourse";
import PaymentsPage from "./components/PaymentsPage";

import Header from './components/Header';
import Footer from './components/Footer';

import MySQLChapter1 from './courseContents/MySQL/Types of Primary Keys';
import MySQLChapter2 from './courseContents/MySQL/Types Of MySQL Queries';
import MySQLChapter3 from './courseContents/MySQL/DataBase Operations';
import MySQLChapter4 from './courseContents/MySQL/Managing Tables';
import MySQLChapter5 from './courseContents/MySQL/MySQL Constraints';

import HtmlCssChapter1 from './courseContents/HTMLCSS/Introduction to HTML5';
import HtmlCssChapter2 from './courseContents/HTMLCSS/Introduction to HTML5';
import HtmlCssChapter3 from './courseContents/HTMLCSS/Introduction to HTML5';
import HtmlCssChapter4 from './courseContents/HTMLCSS/Introduction to HTML5';
import HtmlCssChapter5 from './courseContents/HTMLCSS/Introduction to HTML5';

import JsChapter1 from './courseContents/JavaScript/JavaScript Introduction';
import JsChapter2 from './courseContents/JavaScript/JavaScript object basics';
import JsChapter3 from './courseContents/JavaScript/Object oriented programming';
import JsChapter4 from './courseContents/JavaScript/Arrays and Strings in JS';
import JsChapter5 from './courseContents/JavaScript/Working with JSON';
import JsChapter6 from './courseContents/JavaScript/Demo JavaScript';

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/about" element={<About />} />
        <Route exact path="/login" element={<Login />} />
        <Route exact path="/signup" element={<Signup />} />
        <Route exact path="/products" element={<Products />} />
        <Route exact path="/profile" element={<ProfileEditInfo />} />
        <Route exact path="/profileCourses" element={<ProfileCourses />} />
        <Route exact path="/profileSettings" element={<ProfileSettings />} />
        <Route path="/mysqlcourse" element={<CourseContent />}> 
          <Route path="chapter1" element={<MySQLChapter1 />} />
          <Route path="chapter2" element={<MySQLChapter2 />} />
          <Route path="chapter3" element={<MySQLChapter3 />} />
          <Route path="chapter4" element={<MySQLChapter4 />} />
          <Route path="chapter5" element={<MySQLChapter5 />} />
        </Route>
        <Route path="/htmlcsscourse" element={<CourseContent />}> 
          <Route path="chapter1" element={<HtmlCssChapter1 />} />
          <Route path="chapter2" element={<HtmlCssChapter2 />} />
          <Route path="chapter3" element={<HtmlCssChapter3 />} />
          <Route path="chapter4" element={<HtmlCssChapter4 />} />
          <Route path="chapter5" element={<HtmlCssChapter5 />} />
        </Route>
        <Route path="/jscourse" element={<CourseContent />}> 
          <Route path="chapter1" element={<JsChapter1 />} />
          <Route path="chapter2" element={<JsChapter2 />} />
          <Route path="chapter3" element={<JsChapter3 />} />
          <Route path="chapter4" element={<JsChapter4 />} />
          <Route path="chapter5" element={<JsChapter5 />} />
          <Route path="chapter6" element={<JsChapter6 />} />
        </Route>
        <Route exact path="/coursedetail" element={<CourseDetail />} />
        <Route exact path="/logout" element={<Logout />} />
        <Route exact path="/cart" element={<Cart />} />
        <Route exact path="/addToCourse" element={<AddToCourse />} />
        <Route exact path="/paymentsPage" element={<PaymentsPage />} />
        <Route exact path="/adminDashboard" element={<AdminDashboard />} />
        <Route exact path="/adminDashboardCourse" element={<AdminDashboardCourse />} />
        <Route exact path="/adminDashboardPayments" element={<AdminDashboardPayments />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;