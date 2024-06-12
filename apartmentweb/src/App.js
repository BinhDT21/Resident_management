import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Home from './components/Home/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import VistorCard from './components/VisitorCard/VisitorCard';
import Login from './components/Home/Login';
import { useReducer } from 'react';
import { MyUserReducer } from './configs/Reducers';
import { DispatchContext, UserContext } from './configs/Contexts';
import UpdateUser from './User/UpdateUser';

function App() {
  const [user, useDispatch] = useReducer(MyUserReducer, null)


  return (
    <BrowserRouter>
      <UserContext.Provider value={user}>
        <DispatchContext.Provider value={useDispatch}>
          <Routes>
            <Route path='/' element={<Home />} />
          </Routes>
          <Routes>
            <Route path='/visitor_card' element={<VistorCard />} />
          </Routes>
          <Routes>
            <Route path='/login' element={<Login />} />
          </Routes>
          <Routes>
            <Route path='/update' element={<UpdateUser />} />
          </Routes>
        </DispatchContext.Provider>
      </UserContext.Provider>
    </BrowserRouter>
  );
}

export default App;
