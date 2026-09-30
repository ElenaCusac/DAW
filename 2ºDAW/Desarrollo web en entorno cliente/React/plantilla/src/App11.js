import 'bootstrap/dist/css/bootstrap.min.css';
import { Component } from 'react';
import UserForm from './componentes/UserFormComponent';
import UserList from './componentes/UserListComponent';


class App extends Component {
    constructor() {
        super();
        this.state = {
            users: [
                { id: 1, name: "perico", email: "perico@myfpschool.com" },
                { id: 2, name: "juanico", email: "juanico@myfpschool.com" },
                { id: 3, name: "andrés", email: "andres@myfpschool.com" }
            ]
        }
    }

    handleOnAddUser(event) {
        // Prevenir que la página se recargue
        event.preventDefault();

        let u = this.state.users;

        // Calcular el id para el nuevo usuario
        let idMax = 0;
        u.forEach((user) => {
            if (user.id > idMax) {
                idMax = user.id;
            }
        });

        idMax++;

        // Comprobar si los campos introducidos están vacíos o repetidos
        let valueName = event.target.nombre.value.trim();
        let valueEmail = event.target.email.value.trim();

        if (u.find((user) => user.email === valueEmail)) {
            return;
        }

        if (valueEmail != "" && valueName != "") {
            u.push({ id: idMax, name: valueName, email: valueEmail });
            this.setState({ users: u });
        }

        console.log(idMax)

        event.target.reset();
    }

    render() {
        return (
            <div className="App">
                <UserList users={this.state.users} />
                <UserForm onAddUser={(event) => this.handleOnAddUser(event)} />
            </div>
        );
    }
}

export default App;