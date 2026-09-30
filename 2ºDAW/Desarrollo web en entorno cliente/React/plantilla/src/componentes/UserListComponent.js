import User from "./UserComponent";
const UserList = (props) => {
    let lista = props.users.map(u => <User key={u.id} name={u.name} email={u.email} id={u.id} />)
    return (
        <ul>
            {lista}
        </ul>
    )
}

export default UserList;