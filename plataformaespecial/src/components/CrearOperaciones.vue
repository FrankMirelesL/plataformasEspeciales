<template>
  <div class="p-6 max-w-lg mx-auto bg-white rounded-lg shadow-md">
    <h2 class="text-3xl font-bold text-center text-gray-800 mb-6">
      Crear Operaciones
    </h2>

    <form @submit.prevent="guardarOperacion" class="space-y-4">
      <div>
        <label class="block font-semibold text-gray-700 mb-1"
          >operacion</label
        >
        <input
          v-model="operacion"
          type="text"
          class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
          required
        />
      </div>
      <div>
        <label class="block font-semibold text-gray-700 mb-1"
          >importe</label
        >
        <input
          v-model="importe"
          type="text"
          class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
          required
        />
      </div>
      <div>
        <label class="block font-semibold text-gray-700 mb-1"
          >cliente</label
        >
        <input
          v-model="cliente"
          type="text"
          value="BxjFg/Q/RPsZTksMMfNIFg=="
          class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
          required
        />
      </div>
      <div>
        <label class="block font-semibold text-gray-700 mb-1"
          >secreto</label
        >
        <input
          v-model="secreto"
          type="text"
          class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
          required
        />
      </div>

      <button
        type="submit"
        class="w-full bg-blue-500 text-white py-2 rounded-lg hover:bg-blue-600 transition duration-200"
      >
        Guardar Operacion
      </button>
    </form>
  </div>
</template>

<script>
import api from "@/services/api";

export default {
  data() {
    return {
      id: "",
      estatus: "",
      referencia: "",
      operacion: ""
    };
  },
  async created() {
  },
  methods: {
    async guardarOperacion() {
      try {
        const response = await api.post("/procesar", {
          operacion: this.operacion,
          importe: this.importe,
          cliente: this.cliente,
          secreto: this.secreto,
        });
        alert("Operaion creada con éxito " + response.data);
      } catch (error) {
        alert(
          "Error al crear la operacion: " +
            (error.response?.data?.message || error.message)
        );
      }
    },
  },
};
</script>
