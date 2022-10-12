--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2022-10-08 14:13:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 16497)
-- Name: persons; Type: TABLE; Schema: public; Owner: village_adm
--

CREATE TABLE public.persons (
    name character varying NOT NULL,
    gender character varying NOT NULL,
    age integer,
    pet character varying[]
);


ALTER TABLE public.persons OWNER TO village_adm;

--
-- TOC entry 3301 (class 0 OID 16497)
-- Dependencies: 209
-- Data for Name: persons; Type: TABLE DATA; Schema: public; Owner: village_adm
--

INSERT INTO public.persons VALUES ('Dara', 'MALE', 18, '{CAT}');
INSERT INTO public.persons VALUES ('Thida', 'FEMALE', 17, '{DOG}');
INSERT INTO public.persons VALUES ('Dalin', 'FEMALE', 19, '{DOG,CAT}');
INSERT INTO public.persons VALUES ('Veasna', 'MALE', 16, '{}');
INSERT INTO public.persons VALUES ('Sopheak', 'FEMALE', 17, '{FISH}');
INSERT INTO public.persons VALUES ('Vannda', 'MALE', 21, '{BIRD}');
INSERT INTO public.persons VALUES ('Nary', 'FEMALE', 23, '{DOG,BIRD,CAT}');
INSERT INTO public.persons VALUES ('Pisey', 'FEMALE', 19, '{CAT,RABBIT}');
INSERT INTO public.persons VALUES ('Sovann', 'MALE', 18, '{CAT}');
INSERT INTO public.persons VALUES ('Vannary', 'FEMALE', 20, '{FISH}');


-- Completed on 2022-10-08 14:13:04

--
-- PostgreSQL database dump complete
--

