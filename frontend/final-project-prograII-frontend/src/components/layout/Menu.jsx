import {NavLink} from "react-router-dom";
import {useAuth} from "../../auth/hooks/useAuth.js";


export const Menu = () => {

  const { login } = useAuth();
  console.log(`i am dubbing login ${login.name}`);
  const rolesArray = Array.isArray(login.roles)
      ? login.roles.map(role => role.authority)
      : [];

   let  shouldShowLink = false;
    console.log("Roles Array:", rolesArray);
    if (rolesArray.includes("ROLE_ADMIN")) {
       shouldShowLink = true;
    }

    return (
        <div>
        <aside className="main-sidebar sidebar-dark-primary elevation-4">
          {/* Brand Logo */}
          <div className="brand-link">
            <img
                src="dist/img/logo.jpg"
                alt="AdminLTE Logo"
                className="brand-image img-fluid elevation-10"
                style={{ opacity: '.8' }}
            />
            <span className="brand-text font-weight-light">Lab2YouApp</span>
          </div>
          {/* Sidebar */}
          <div className="sidebar">
            {/* Sidebar user panel (optional) */}
            <div className="user-panel mt-3 pb-3 mb-3 d-flex">
              <div className="image">
                <img src="dist/img/user1-128x128.jpg" className="img-circle elevation-2" alt="User Image" />
              </div>
              <div className="info">
                <div className="d-block" style={{ color: 'white' }}>{login.name}</div>
              </div>
            </div>
            {/* Sidebar Menu */}
            <nav className="mt-2">
              <ul className="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                {/* Add icons to the links using the .nav-icon class
                 with font-awesome or any other icon font library */}
                <li className="nav-item has-treeview menu-open">

                  <NavLink to="/" className="nav-link active">
                    <i className="nav-icon fas fa-tachometer-alt" />
                    <p>
                      Dashboard
                    </p>
                  </NavLink>
                </li>

                {shouldShowLink && <li className="nav-item has-treeview">
                  <a href="#" className="nav-link">
                    <i className="nav-icon fas fa-users" />
                    <p>
                      Control de Usuarios
                      <i className="fas fa-angle-left right" />
                      {/* <span className="badge badge-info right">6</span> */}
                    </p>
                  </a>
                  <ul className="nav nav-treeview">
                    
                    <li className="nav-item">
                      <NavLink to="/cardsView" className="nav-link">
                        <i className="fas fa-user-plus" />
                        <p> Agregar nuevo usuario</p>
                      </NavLink>
                    </li>
                    <li className="nav-item">
                      <a href="pages/layout/collapsed-sidebar.html" className="nav-link">
                        <i className="fas fa-list" />
                        <p> Listar Usuarios</p>
                      </a>
                    </li>
                  </ul>
                </li> }
                <li className="nav-item has-treeview">
                  <a href="#" className="nav-link">
                    <i className="nav-icon fas fa-chart-pie" />
                    <p>
                      Charts
                      <i className="right fas fa-angle-left" />
                    </p>
                  </a>
                  <ul className="nav nav-treeview">
                    <li className="nav-item">
                      <a href="pages/charts/chartjs.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>ChartJS</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/charts/flot.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Flot</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/charts/inline.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Inline</p>
                      </a>
                    </li>
                  </ul>
                </li>
                <li className="nav-item has-treeview">
                  <a href="#" className="nav-link">
                    <i className="nav-icon fas fa-tree" />
                    <p>
                      UI Elements
                      <i className="fas fa-angle-left right" />
                    </p>
                  </a>
                  <ul className="nav nav-treeview">
                    <li className="nav-item">
                      <a href="pages/UI/general.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>General</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/UI/icons.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Icons</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/UI/buttons.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Buttons</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/UI/sliders.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Sliders</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/UI/modals.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Modals &amp; Alerts</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/UI/navbar.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Navbar &amp; Tabs</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/UI/timeline.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Timeline</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/UI/ribbons.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Ribbons</p>
                      </a>
                    </li>
                  </ul>
                </li>
                <li className="nav-item has-treeview">
                  <a href="#" className="nav-link">
                    <i className="nav-icon fas fa-edit" />
                    <p>
                      Forms
                      <i className="fas fa-angle-left right" />
                    </p>
                  </a>
                  <ul className="nav nav-treeview">
                    <li className="nav-item">
                      <a href="pages/forms/general.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>General Elements</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/forms/advanced.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Advanced Elements</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/forms/editors.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Editors</p>
                      </a>
                    </li>
                  </ul>
                </li>
                <li className="nav-item has-treeview">
                  <a href="#" className="nav-link">
                    <i className="nav-icon fas fa-table" />
                    <p>
                      Tables
                      <i className="fas fa-angle-left right" />
                    </p>
                  </a>
                  <ul className="nav nav-treeview">
                    <li className="nav-item">
                      <a href="pages/tables/simple.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Simple Tables</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/tables/data.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>DataTables</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/tables/jsgrid.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>jsGrid</p>
                      </a>
                    </li>
                  </ul>
                </li>
                <li className="nav-header">EXAMPLES</li>
      
              
                <li className="nav-item has-treeview">
                  <a href="#" className="nav-link">
                    <i className="nav-icon fas fa-book" />
                    <p>
                      Pages
                      <i className="fas fa-angle-left right" />
                    </p>
                  </a>
                  <ul className="nav nav-treeview">
        
                      <a href="pages/examples/project_add.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Project Add</p>
                      </a>
                    
                    <li className="nav-item">
                      <a href="pages/examples/project_edit.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Project Edit</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/project_detail.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Project Detail</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/contacts.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Contacts</p>
                      </a>
                    </li>
                  </ul>
                </li>
                <li className="nav-item has-treeview">
                  <a href="#" className="nav-link">
                    <i className="nav-icon far fa-plus-square" />
                    <p>
                      Extras
                      <i className="fas fa-angle-left right" />
                    </p>
                  </a>
                  <ul className="nav nav-treeview">
                    <li className="nav-item">
                      <a href="pages/examples/login.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Login</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/register.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Register</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/forgot-password.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Forgot Password</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/recover-password.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Recover Password</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/lockscreen.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Lockscreen</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/legacy-user-menu.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Legacy User Menu</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/language-menu.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Language Menu</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/404.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Error 404</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/500.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Error 500</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/pace.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Pace</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="pages/examples/blank.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Blank Page</p>
                      </a>
                    </li>
                    <li className="nav-item">
                      <a href="starter.html" className="nav-link">
                        <i className="far fa-circle nav-icon" />
                        <p>Starter Page</p>
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
            {/* /.sidebar-menu */}
          </div>
          {/* /.sidebar */}
        </aside>
      </div>
    )
}