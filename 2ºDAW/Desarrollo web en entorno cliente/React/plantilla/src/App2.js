import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import { Component } from 'react';

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            euros: 0,
            dolares: 0,
        }
    }

    suma() {
        const euros = this.state.euros + 1;
        const dolares = euros * 1.12;

        this.setState({
            euros: euros,
            dolares: dolares,
        });
    }

    resta() {
        if (this.state.euros > 0) {
            const euros = this.state.euros - 1;
            const dolares = euros * 1.12;

            this.setState({
                euros: euros,
                dolares: dolares,
            });
        }
    }

    render() {
        return (
            <div className="App">
                <h3>Euros</h3>
                <h4>{this.state.euros} €</h4>
                <Button color="primary" onClick={() => this.suma()}>+</Button>
                <Button color="primary" onClick={() => this.resta()}>-</Button>

                <h3>Dólares</h3>
                <h4>{this.state.dolares.toFixed(2)} $</h4>
            </div>
        );
    }
}

export default App;