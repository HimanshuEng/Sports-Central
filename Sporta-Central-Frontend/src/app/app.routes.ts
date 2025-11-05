import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { HistoryComponent } from './pages/history/history.component';
import { LiveComponent } from './pages/live/live.component';
import { PointTableComponent } from './pages/point-table/point-table.component';
import { CategoriesComponent } from './pages/categories/categories.component';
import { footballComponent } from './pages/football/football.component';
import { NewsArticleComponent } from './pages/news-article/news-article.component';

export const routes: Routes = 
[
    
   {
    path:"home",
    component:HomeComponent,
    title:"Home page"
   } ,
   {
    path:"history",
    component:HistoryComponent,
    title:"Match History"

   },
   {
    path:"live",
    component:LiveComponent,
    title:"Live Matches"
   },
   {
    path:"point-table",
    component:PointTableComponent,
    title:"Point Table"
   },
   {
      path:"Categories",
      component:CategoriesComponent,
      title:"Categories"
   },
   {
      path:"football",
      component:footballComponent,
      title:"football Live Score"
   },
   {
      path:"newsarticles",
      component:NewsArticleComponent,
      title:"newsarticles"
   }
];
