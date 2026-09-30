import { Button } from "reactstrap";

const User = (props) => {
    return (
        <li>{props.id}. {props.name} - {props.email} - <Button color="danger">Eliminar Nº {props.id}</Button></li>
    )
}
export default User;