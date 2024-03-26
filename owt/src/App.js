//import logo from './logo.svg';
//import './App.css';
import * as Pages from './pages';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
    
    <Router>
      <Routes>
        <Route path="/" element={<Pages.Home />} />
      </Routes>
    </Router>

    // will need to import components differently if it's needed for this project but that's it for pages




    /*default setup below
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
    // end default setup */


  );
}

export default App;
