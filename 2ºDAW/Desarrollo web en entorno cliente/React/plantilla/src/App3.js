//import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import { Component } from 'react';

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            color1: "secondary",
            color2: "secondary",
            color3: "secondary",
        };
    }

    cambiarColor1() { 
        this.setState(
            { 
                color1: "primary", 
                color2: "secondary", 
                color3: "secondary", 
            }
        ); 
    }

    cambiarColor2() { 
        this.setState(
            {
                color1: "secondary", 
                color2: "danger", 
                color3: "secondary", 

            }
        ); 
    }

    cambiarColor3() { 
        this.setState(
            { 
                color1: "secondary", 
                color2: "secondary", 
                color3: "warning",
            }
        ); 
    }

    render() {
        return(
            <div className="App">
                <Button color={this.state.color1} onClick={() => this.cambiarColor1()}><h1>Botón 1</h1></Button>
                <Button color={this.state.color2} onClick={() => this.cambiarColor2()}><h1>Botón 2</h1></Button>
                <Button color={this.state.color3} onClick={() => this.cambiarColor3()}><h1>Botón 3</h1></Button>
            </div>
        );
    }
}

export default App;