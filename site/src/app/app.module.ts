import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AuthService } from './auth.service';

import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BrowseVideosComponent } from './browse-videos/browse-videos.component';
import { ProfilePageComponent} from './profile-page/profile-page.component';
import { ContactComponent} from './contact/contact.component';
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';
import * as jwt_decode from '../../node_modules/jwt-decode';
import { VideoDetailsComponent } from './video-details/video-details.component';
import { SafePipe } from './safe.pipe';


const appRoutes: Routes = [
  { path: 'signin',
    component: SigninComponent
  },
   { path: 'register',
    component: RegisterComponent
  },
  { path: 'browse',
    component: BrowseVideosComponent
  },
  { path: '',
    redirectTo: '/browse',
    pathMatch: 'full'
  },
  { path: 'video/:id', component: VideoDetailsComponent },
  
  { path: 'profilepage',
    component: ProfilePageComponent
  },
  {
    path: '',
    redirectTo: '/profilepage',
     pathMatch: 'full'
    
  },
    { path: 'contact',
    component: ContactComponent
  },
  {
    path: '',
    redirectTo: '/contact',
     pathMatch: 'full'
    
  },
  { path: '**', component: PageNotFoundComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    PageNotFoundComponent,
    BrowseVideosComponent,
    VideoDetailsComponent,
    ProfilePageComponent,
    ContactComponent,
    RegisterComponent,
    SafePipe
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
