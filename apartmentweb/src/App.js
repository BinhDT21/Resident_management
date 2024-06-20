import 'bootstrap/dist/css/bootstrap.min.css';
import Cookies from 'js-cookie';
import { useReducer } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Feedback from './components/ComplainAndFeedback/Feedback';
import Survey from './components/ComplainAndFeedback/Survey';
import Home from './components/Home/Home';
import Login from './components/Home/Login';
import Invoice from './components/Payment/Invoice';
import VistorCard from './components/VisitorCard/VisitorCard';
import { DispatcherContext, UserContext } from './configs/Contexts';
import { MyUserReducer } from './configs/Reducers';

function App() {
  let currentUser = null
  if (Cookies.get('user')) currentUser = JSON.parse(Cookies.get('user'))
  const [user, useDispatch] = useReducer(MyUserReducer, currentUser);

  return (
    <BrowserRouter>
      <UserContext.Provider value={user}>
          <DispatcherContext.Provider value={useDispatch}>
            <Routes>
              <Route path='/login' element={<Login/>}/>
              <Route path='/' element={<Home/>}/>
              <Route path='/visitor_card' element={<VistorCard/>}/>
              <Route path='/invoice' element={<Invoice/>}/>
              <Route path='/feedback' element={<Feedback/>}/>
              <Route path='/survey' element={<Survey/>}/>
            </Routes>
            </DispatcherContext.Provider>
        </UserContext.Provider>
    </BrowserRouter>
  );
}

export default App;
