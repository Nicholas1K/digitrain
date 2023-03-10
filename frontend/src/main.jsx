import React from "react";
import ReactDOM from "react-dom/client";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import theme from "./context/theme";

// App
import Welcome from "./App/Welcome";
import Prenota from "./App/Prenota";
import Conditions from "./App/Conditions";
import Prenotazioni from "./App/Prenotazioni";
import Prenotazione from "./App/Prenotazione";
import CSV from "./App/csv";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Welcome />} />
          <Route path="/prenota" element={<Prenota />} />
          <Route path="/condizioni" element={<Conditions />} />
          <Route path="/prenotazioni" element={<Prenotazioni />} />
          <Route path="/prenotazione/:id" element={<Prenotazione />} />
          <Route path="/carica" element={<CSV />} />
        </Routes>
      </BrowserRouter>
    </ThemeProvider>
  </React.StrictMode>
);
