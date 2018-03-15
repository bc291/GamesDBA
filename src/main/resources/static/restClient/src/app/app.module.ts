import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{RouterModule, Routes}   from '@angular/router';
import{HttpModule}   from '@angular/http';
import{FormsModule}   from '@angular/forms';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import{UserService}   from './shared-service/user.service';
import{StatisticsService}   from './shared-service/statistics.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CollapseModule, BsDropdownModule } from 'ngx-bootstrap';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { FormBuilder } from '@angular/forms';
import { ChartsModule } from 'ng2-charts';
import { MainpagecComponent } from './components/mainpagec/mainpagec.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatGridListModule, MatCardModule } from '@angular/material';
import {MatListModule} from '@angular/material/list';

const appRoutes:Routes=[
{path:'', component:MainpagecComponent},
{path:'op', component:UserFormComponent},
{path:'statistics', component:StatisticsComponent},
{path:'gamelibrary', component:ListuserComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    NavbarComponent,
    StatisticsComponent,
    MainpagecComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    CollapseModule.forRoot(),
    BsDropdownModule.forRoot(),
    ChartsModule,
    NgbModule.forRoot(),
    BrowserAnimationsModule,
    MatCardModule,
    MatListModule,
      MatGridListModule
  ],
  providers: [UserService, StatisticsService],
  bootstrap: [AppComponent]
})
export class AppModule { }



