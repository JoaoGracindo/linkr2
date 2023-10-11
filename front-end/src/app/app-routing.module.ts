import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { FeedComponent } from './components/feed/feed.component';
import { authGuard } from './shared/auth.guard';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'signup', component: RegisterComponent },
  {
    path: 'feed',
    component: FeedComponent,
    canActivate: [authGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
