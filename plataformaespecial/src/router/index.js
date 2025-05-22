import { createRouter, createWebHistory } from "vue-router";
import CrearOperaciones from "@/components/CrearOperaciones.vue";

const routes = [
  {
    path: "/crear-operaciones",
    component: CrearOperaciones,
    meta: { requiresAuth: true },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
