import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PatientDetailsComponent } from './Pages/patient-details/patient-details.component';
import { SidebarComponent } from './Pages/Patient/sidebar/sidebar.component';
import { VisitDetailsComponent } from './Pages/Patient/visit-details/visit-details.component';
import { PatientDashboardComponent } from './Pages/Patient/patient-dashboard/patient-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    PatientDetailsComponent,
    SidebarComponent,
    VisitDetailsComponent,
    PatientDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
