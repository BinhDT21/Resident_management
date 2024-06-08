import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Home from './components/Home/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import VistorCard from './components/VisitorCard/VisitorCard';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home/>}/>
      </Routes>
      <Routes>
        <Route path='/visitor_card' element={<VistorCard/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
